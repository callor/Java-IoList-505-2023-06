package com.callor.iolist.models;

public class IolistDto {
	
	public long ioSEQ;//	NUMBER
	public String ioDate;//	VARCHAR2(10)
	public String ioTime;//	VARCHAR2(10)
	public String ioBuId;//	VARCHAR2(10)
	public String ioPCode;//	VARCHAR2(13)
	public int ioQuan;//	NUMBER
	public int ioPrice;//	NUMBER
	public int ioTotal;//	NUMBER
	public IolistDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IolistDto(long ioSEQ, String ioDate, String ioTime, String ioBuId, String ioPCode, int ioQuan, int ioPrice,
			int ioTotal) {
		super();
		this.ioSEQ = ioSEQ;
		this.ioDate = ioDate;
		this.ioTime = ioTime;
		this.ioBuId = ioBuId;
		this.ioPCode = ioPCode;
		this.ioQuan = ioQuan;
		this.ioPrice = ioPrice;
		this.ioTotal = ioTotal;
	}
	@Override
	public String toString() {
		return "IolistDto [ioSEQ=" + ioSEQ + ", ioDate=" + ioDate + ", ioTime=" + ioTime + ", ioBuId=" + ioBuId
				+ ", ioPCode=" + ioPCode + ", ioQuan=" + ioQuan + ", ioPrice=" + ioPrice + ", ioTotal=" + ioTotal + "]";
	}

}
