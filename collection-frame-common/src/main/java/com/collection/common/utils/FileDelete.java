package com.collection.common.utils;

import java.io.File;

public class FileDelete {

	private boolean flag;
	
	public static void main(String[] args){
		
		
	}
	
    /**
     * ɾ��Ŀ¼���ļ��У��Լ�Ŀ¼�µ��ļ�
     * @param   sPath ��ɾ��Ŀ¼���ļ�·��
     * @return  Ŀ¼ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteDirectory(String sPath) {
        //���sPath�����ļ��ָ�����β���Զ�����ļ��ָ���
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        flag = true;
        //ɾ���ļ����µ������ļ�(������Ŀ¼)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //ɾ�����ļ�
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //ɾ����Ŀ¼
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //ɾ����ǰĿ¼
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * ɾ�������ļ�
     * @param   sPath    ��ɾ���ļ����ļ���
     * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
     */
    public boolean deleteFile(String sPath) {
        flag = false;
        File file = new File(sPath);
        // ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
