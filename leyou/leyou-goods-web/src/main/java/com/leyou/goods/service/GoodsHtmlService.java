package com.leyou.goods.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;

@Service
public class GoodsHtmlService {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private GoodsService goodsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsHtmlService.class);

    /**
     * 创建html页面，实现页面静态化
     *
     * @param spuId
     */
    public void createHtml(Long spuId) {
        PrintWriter printWriter = null;
        try {
            // 获取页面数据
            Map<String, Object> map = this.goodsService.loadData(spuId);
            // 初始化thymeleaf上下文对象
            Context context = new Context();
            // 把数据放入上下文对象
            context.setVariables(map);
            // 创建输出流
            File file = new File("C:\\tools\\nginx-1.14.0\\html\\item\\" + spuId + ".html");
            printWriter = new PrintWriter(file);
            this.templateEngine.process("item", context, printWriter);
        } catch (Exception e) {
            LOGGER.error("页面静态化出错：{}，" + e, spuId);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public void deleteHtml(Long id) {
        File file = new File("C:\\tools\\nginx-1.14.0\\html\\item\\"+id + ".html");
        file.deleteOnExit();
    }
}
