package io.fileClass;

import java.io.File;

public class Program2 {

	public static void main(String[] args) {
		
		// определяем объект для каталога, здесь нет проверки о наличии файла
        File dir = new File("C://eclipse-workspace//NewDir");
       boolean created = dir.mkdir();
        if(created)
            System.out.println("Folder has been created");
        // переименуем каталог
          File newDir = new File("C://eclipse-workspace//NewDirRename");
          System.out.println(newDir);
              dir.renameTo(newDir);
        // удалим каталог
         boolean deleted = newDir.delete();
        if(deleted)
            System.out.println("Folder has been deleted");

	}

}
