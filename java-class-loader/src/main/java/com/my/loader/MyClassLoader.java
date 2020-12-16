package com.my.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader{

    private String path;

    public MyClassLoader(String classPath){
        path = classPath;
    }


    /**
     * @Author: Mr.zh on 2020/7/21 0021 15:30
     * @param: [name] 类的全路径
     * @return: java.lang.Class<?>
     * @Description:
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        Class log = null;
        byte[] data = getData();
        if (data!=null){
             log = defineClass(name, data, 0, data.length);
        }
        return log;

    }

    private byte[] getData(){
        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try{
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);

                }
            }catch (Exception e){
               e.printStackTrace();
            }
            return out.toByteArray();


        }
        return null;
    }
}
