package com.zjz.controller;


import com.zjz.entity.po.Information;
import com.zjz.service.FileService;
import com.zjz.untils.Result;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;




@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FileController {
    @Resource
    private FileService fileService;

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, String type,String title, HttpServletRequest request) throws Exception {
        if (file.isEmpty()) {
           return new Result().result500("上传文件不能为空","/hbb/file/upload");
        }
        //获取文件后缀
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //修改文件的名字
        String fileName = new Date().getTime()+"."+fileExt;
        //文件保存的路径
        String path = "D:\\ideaproject\\zjz_hd\\src\\main\\upload"+"/"+fileName;
        File dest = new File(path);
        //保存上传的文件
        file.transferTo(dest);

        //把文件相关信息保存到数据库
        Information information = new Information();
        information.setInfoId(UUID.randomUUID().toString());
        information.setInfoPath(path);
        information.setInfoType(type);
        information.setInfoTitle(title);
        information.setAddedTime(System.currentTimeMillis());
        boolean b = fileService.saveInformation(information);
        if (b == true){
            return new Result().result200("资料上传成功", "/hbb/file/upload");
        }
          return new Result().result500("资料上传失败", "/hbb/file/upload");
    }
    /**
     * 下载文件
     */
    @GetMapping("/download")
    public void download(@RequestParam String infoId, HttpServletRequest request, HttpServletResponse response) {
        String filePath = fileService.getInformationPath(infoId);
        // 创建一个File对象，传入文件路径
        File file2 = new File(filePath);
        // 使用getName()方法获取文件名
        String fileName = file2.getName();
        System.out.println(fileName);
//        String path = "D:\\ideaproject\\zjz_hd\\src\\main\\upload"+"/"+fileName;
//        try {
//            File file = new File(path);
//            if (file.exists()) {
//                response.reset();
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+"\"");
//                response.setHeader("Cache-Control", "no-cache");
//                response.setContentType("application/octet-stream; charset=UTF-8");
//                //将文件写入输出流
//                IOUtils.write(FileUtils.readFileToByteArray(file), response.getOutputStream());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            // path是指想要下载的文件的路径
            File file = new File(filePath);
            // 获取文件名
            String filename = file.getName();
            // 获取文件后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();

            // 将文件写入输入流
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStream fis = new BufferedInputStream(fileInputStream);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            //attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.addHeader(  "Access-Control-Allow-Origin","*");//允许所有来源访同
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 查看所有资料
     */
    @RequestMapping("/getTypeInformation")
    public Result getTypeInformation(int pageNum, int pageSize,String type) {
        System.out.println(type);
        if (type.equals("")){
            return  fileService.getAllInformation(pageNum,  pageSize,"/hbb/file/getTypeInformation");
        }else{
            return  fileService.getTypeInformation(pageNum,  pageSize,type,"/hbb/file/getTypeInformation");
        }
     }

}