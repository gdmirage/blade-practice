package com.blade.practice.controller;

import com.blade.practice.util.FreeMarkerUtil;
import com.blade.practice.util.WKHtmlToPdfUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Blade
 * @date 2019-06-15 14:20:34
 **/

@Controller
@RequestMapping("/practice")
public class PracticeController {

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @PostMapping("/bill/export")
    public ResponseEntity<byte[]> billExport(HttpServletRequest request) throws Exception {

        String name = "发票模板";
        String ftlType = "";
        if ("EN".equals("")) {
            ftlType = "indexEN.ftl";
        } else {
            ftlType = "indexCN.ftl";
        }

        Map<String, Object> entity = new HashMap<>(16);
        entity.put("company", "Blade company");
        String content = FreeMarkerUtil.getContent(ftlType, entity);

//		String path = SupplierStatementService.class.getClassLoader().getResource("").getPath();
        String htmlPath = "/home/jenkins/indexCN_temp_h";
        String pdfPath = "/home/jenkins/indexCN_temp_p.pdf";
        // 写成HTML
        WKHtmlToPdfUtil.strToHtmlFile(content, htmlPath);
        // 转成PDFai
        WKHtmlToPdfUtil.htmlToPdf(htmlPath + ".html", pdfPath);
        // 读取，获取流
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/octet-stream");
        if ("firefox".equals(getExplorerType(request))) {
            String excelName = new String((name + ".pdf").getBytes("GB2312"), "ISO-8859-1");
            headers.add("Content-Disposition", "attachment; filename=" + excelName);
        } else {
            String excelName = URLEncoder.encode(name + ".pdf", "UTF-8");
            headers.add("Content-Disposition", "attachment;filename=" + excelName);
        }

        return new ResponseEntity<byte[]>(inputTobyte(new FileInputStream(new File(pdfPath))), headers, HttpStatus.OK);
    }

    /**
     * 获取浏览器类型
     *
     * @param request
     * @return
     */
    public static String getExplorerType(HttpServletRequest request) {
        String agent = request.getHeader("USER-AGENT");
        if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
            return "firefox";
        } else if (agent != null && agent.toLowerCase().indexOf("msie") > 0) {
            return "ie";
        } else if (agent != null && agent.toLowerCase().indexOf("chrome") > 0) {
            return "chrome";
        } else if (agent != null && agent.toLowerCase().indexOf("opera") > 0) {
            return "opera";
        } else if (agent != null && agent.toLowerCase().indexOf("safari") > 0) {
            return "safari";
        }
        return "others";
    }

    private static byte[] inputTobyte(InputStream inStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[2048];
        int bytesRead = 0;
        while ((bytesRead = inStream.read(buff, 0, buff.length)) > 0) {
            baos.write(buff, 0, bytesRead);
        }
        return baos.toByteArray();
    }
}
