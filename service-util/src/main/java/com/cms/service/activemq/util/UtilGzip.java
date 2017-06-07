package com.cms.service.activemq.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Gzip工具
 *
 */
public class UtilGzip {
	/**
	 * gzip压缩字节数组
	 * @param buffer
	 * @return
	 * @throws IOException
	 */
	public static byte[] compress(byte[] buffer) {
		ByteArrayOutputStream arrayOutputStream = null;
		GZIPOutputStream gzip = null;
		ByteArrayInputStream inputStream = null;

		try {
			arrayOutputStream = new ByteArrayOutputStream();
			gzip = new GZIPOutputStream(arrayOutputStream);
			inputStream = new ByteArrayInputStream(buffer);
			byte[] buf = new byte[2048];
			int len = 0;
			while ((len = inputStream.read(buf)) != -1) {
				gzip.write(buf, 0, len);
			}

			gzip.finish();

			byte[] result = arrayOutputStream.toByteArray();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return buffer;
		} finally {
			if(gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(arrayOutputStream != null) {
				try {
					arrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * gzip解压字节数组
	 * @param buffer
	 * @return
	 * @throws IOException
	 */
	public static byte[] decompress(byte[] buffer) {
		ByteArrayInputStream inputStream = null;
		// Open the compressed stream
		GZIPInputStream gzip = null;

		ByteArrayOutputStream out = null;

		try {
			inputStream = new ByteArrayInputStream(buffer);
			gzip = new GZIPInputStream(inputStream);
			out = new ByteArrayOutputStream();
			// Transfer bytes from the compressed stream to the output stream
			byte[] buf = new byte[2048];
			int len;
			while ((len = gzip.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return buffer;
		} finally {
			// Close the file and stream
			if(gzip != null) {
				try {
					gzip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
