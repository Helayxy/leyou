package com.leyou.cart.service;

import com.leyou.cart.client.GoodsClient;
import com.leyou.cart.interceptor.LoginInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.pojo.UserInfo;
import com.leyou.common.utils.JsonUtils;
import com.leyou.item.pojo.Sku;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GoodsClient goodsClient;

    private static final String KEY_PREFIX = "user:cart";

    /**
     * 用户登录状态下新增购物车
     *
     * @param cart
     */
    public void addCart(Cart cart) {

        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();

        // 查询购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = this.redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());

        String key = cart.getSkuId().toString();
        Integer num = cart.getNum();
        // 判断当前的商品是否在购物车中
        if (hashOperations.hasKey(key)) {
            // 如果在购物车中，更新数量
            String cartJson = hashOperations.get(key).toString();
            cart = JsonUtils.parse(cartJson, Cart.class);
            cart.setNum(cart.getNum() + num);
        } else {
            // 如果不在购物车中，新增商品到购物车
            Sku sku = this.goodsClient.querySkuBySkuId(cart.getSkuId());
            cart.setUserId(userInfo.getId());
            cart.setTitle(sku.getTitle());
            cart.setOwnSpec(sku.getOwnSpec());
            cart.setImage(StringUtils.isBlank(sku.getImages()) ? "" : StringUtils.split(sku.getImages(), ",")[0]);
            cart.setPrice(sku.getPrice());
        }
        hashOperations.put(key, JsonUtils.serialize(cart));

    }

    /**
     * 查询购物车
     *
     * @return
     */
    public List<Cart> queryCarts() {

        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        // 判断用户是否有购物车记录
        if (!this.redisTemplate.hasKey(KEY_PREFIX + userInfo.getId())) {
            return null;
        }
        // 如果有，获取用户的购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = this.redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        // 获取购物车集合，json类型
        List<Object> cartsJson = hashOperations.values();

        // 如果购物车集合为空，直接返回null
        if (CollectionUtils.isEmpty(cartsJson)) {
            return null;
        }
        // 把list<Object>集合转化为List<Cart>集合
        return cartsJson.stream().map(cartJson -> JsonUtils.parse(cartJson.toString(), Cart.class)).collect(Collectors.toList());
    }

    /**
     * 更新购物车数量
     *
     * @param cart
     * @return
     */
    public void updateNum(Cart cart) {

        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();

        // 判断用户是否有购物车记录
        if (!this.redisTemplate.hasKey(KEY_PREFIX + userInfo.getId())) {
            return;
        }
        // 获取购物车中的商品数量
        Integer num = cart.getNum();
        // 如果有，获取用户的购物车记录
        BoundHashOperations<String, Object, Object> hashOperations = this.redisTemplate.boundHashOps(KEY_PREFIX + userInfo.getId());
        String cartJson = hashOperations.get(cart.getSkuId().toString()).toString();
        // cartJson反序列化为Cart对象
        cart = JsonUtils.parse(cartJson, Cart.class);
        // 重新设置购物车数量
        cart.setNum(num);
        hashOperations.put(cart.getSkuId().toString(), JsonUtils.serialize(cart));
    }

    /**
     * 删除购物车中的商品
     *
     * @param skuId
     * @return
     */
    public void deleteCart(String skuId) {
        // 获取用户信息
        UserInfo userInfo = LoginInterceptor.getUserInfo();
        String key = KEY_PREFIX + userInfo.getId();
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(key);
        hashOps.delete(skuId);
    }
}
