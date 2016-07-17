package net.ewide.util;

/**
 * ClassName: CRC16M <br/>
 * Function: CRC16验证. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2014年11月23日 下午3:01:28 <br/>
 *
 * @author Alex
 * @version
 * @since JDK 1.7
 */
public class CRC16M {
	/**
	 * toCRC16:(这里用一句话描述这个方法的作用). <br/>
	 * @author Alex
	 * @param bufData
	 * @param buflen
	 * @param pcrc
	 * @return
	 * @since JDK 1.7
	 */
	public static int toCRC16(byte[] bufData, int buflen, byte[] pcrc) {
		int ret = 0;
		int CRC = 0x0000ffff;
		int POLYNOMIAL = 0x0000a001;
		int i, j;

		if (buflen == 0) {
			return ret;
		}
		for (i = 0; i < buflen; i++) {
			CRC ^= ((int) bufData[i] & 0x000000ff);
			for (j = 0; j < 8; j++) {
				if ((CRC & 0x00000001) != 0) {
					CRC >>= 1;
					CRC ^= POLYNOMIAL;
				} else {
					CRC >>= 1;
				}
			}
			// System.out.println(Integer.toHexString(CRC));
		}

//		System.out.println(Integer.toHexString(CRC));
		pcrc[0] = (byte) (CRC & 0x00ff);
		pcrc[1] = (byte) (CRC >> 8);

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		5a 55 02 00 00 00 03 00 00 00 18 00 0b 00 70 0e 00 83 8d 00 00 00 00 00 00 4b 0e 6a 69
		byte[] aa = {0x02,0x00,0x00,0x00,0x03,0x00,0x00,0x00,0x1b,0x00,0x09,0x00,(byte)0x80,0x20,0x14,0x11,0x26,0x14,0x08,0x32,0x00};
		byte[] bb = new byte[2];
		toCRC16(aa, aa.length, bb);
//		bb = ByteUtil.reverse(bb);
		System.out.println(ByteUtil.toHexStringSpace(bb));
//		System.out.println(ByteUtil.toHexStringSpace(bb));
//		System.out.println(Integer.toHexString((int) bb[0] & 0x000000ff));
//		System.out.println(Integer.toHexString((int) bb[1] & 0x000000ff));

	}
}
