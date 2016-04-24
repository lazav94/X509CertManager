package sm130075.vl130298.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;

public class KeyStoreManager {
	String path;
	String password;
	KeyStore keyStore;

	public KeyStoreManager(String path, String password) {
		try {
			this.path = path;
			this.password = password;
			keyStore = KeyStore.getInstance("pkcs12");
			Path p = Paths.get(path);
			
			if(!Files.exists(p)){
				keyStore.load(null, null);
		        keyStore.store(new FileOutputStream(path), password.toCharArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void storeKey(Key key, String alias, String password) {
		try {
			
			keyStore.load(null, null);
			keyStore.setKeyEntry(alias, key, password.toCharArray(), null);
			OutputStream writeStream = new FileOutputStream(path);
			keyStore.store(writeStream, this.password.toCharArray());
			writeStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Key getKey(String alias, String password) {
		try {
			KeyStore keyStore = KeyStore.getInstance("pkcs12");
			FileInputStream fStream = new FileInputStream(path);
			keyStore.load(fStream, this.password.toCharArray());
			
			if (!keyStore.containsAlias(alias)) { 
				 return null;
			} 
			
			Key key = keyStore.getKey(alias, password.toCharArray());
			fStream.close();
			
			
			return key;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public Key getKey(String alias) {
		try {
			KeyStore keyStore = KeyStore.getInstance("pkcs12");
			FileInputStream fStream = new FileInputStream(path);
			keyStore.load(fStream, this.password.toCharArray());
			Key key = keyStore.getKey(alias, null);
			fStream.close();
			
			return key;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public void storeKey(Key key, String alias) {
		try {
			keyStore.load(null, null);
			keyStore.setKeyEntry(alias, key.getEncoded(), null);
			OutputStream writeStream = new FileOutputStream(path);
			keyStore.store(writeStream, this.password.toCharArray());
			writeStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
