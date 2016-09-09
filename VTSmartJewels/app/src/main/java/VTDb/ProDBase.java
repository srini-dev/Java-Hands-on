package VTDb;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProDBase {

	public static final String DBName="VjDb.db";
	public static final int ver=19;
	public static Context ctx;
	public SQLiteDatabase SQ;
	public SQLiteDatabase database;
	public static final String DATABASE_FILE_PATH = "/sdcard/vijayDb";

	public static final String[] SalTabColA=new String[]{AllTabs.keya_id,AllTabs.keya_bn,AllTabs.keya_bnsub,AllTabs.keya_sln,AllTabs.keya_itmnam,AllTabs.keya_wts};
	public static final String[] BilTabColB=new String[]{AllTabs.keya_id,AllTabs.keyb_bn,AllTabs.keya_bnsub,AllTabs.keyb_dat,AllTabs.keyb_cstnam,AllTabs.keyb_wts,AllTabs.keyb_perc,AllTabs.keyb_fin,AllTabs.keyb_rat,AllTabs.keyb_totamt};
	public static final String[] PayTabColC=new String[]{AllTabs.keyc_id,AllTabs.keyc_bn,AllTabs.keyc_bamt,AllTabs.keyc_pid,AllTabs.keyc_pdat,AllTabs.keyc_pamt,AllTabs.keyc_bal};
	public ProDBase() {
		database = SQLiteDatabase.openOrCreateDatabase(DATABASE_FILE_PATH + File.separator + DBName, null);
		//createTables();
		
	}


	public void createTables() {

		Log.d("DB ProDBase", "DB Called");
		database.execSQL("create table " + AllTabs.TabNameA + " (" + AllTabs.keya_id + " integer primary key autoincrement," + AllTabs.keya_bn + " integer," + AllTabs.keya_bnsub + " integer," + AllTabs.keya_sln + " integer, " + AllTabs.keya_itmnam + "  String, " + AllTabs.keya_wts + "  double)");
		database.execSQL("create table " + AllTabs.TabNameB + " (" + AllTabs.keyb_id + " integer primary key autoincrement," + AllTabs.keyb_bn + " integer," + AllTabs.keyb_bnsub + " integer," + AllTabs.keyb_dat + " String," + AllTabs.keyb_cstnam + " String," + AllTabs.keyb_wts + " double," + AllTabs.keyb_perc + " double," + AllTabs.keyb_fin + " double," + AllTabs.keyb_rat + " double," + AllTabs.keyb_totamt + " double)");
		database.execSQL("create table " + AllTabs.TabNameC + " (" + AllTabs.keyc_id + " integer primary key autoincrement," + AllTabs.keyc_bn + " integer,"+ AllTabs.keyc_bamt + " double," + AllTabs.keyc_pid + " integer, " + AllTabs.keyc_pdat + "  String, " + AllTabs.keyc_pamt + "  double, " + AllTabs.keyc_bal + "  double)");
		Log.d("DB ProDBase", "DB Created");
		//database.execSQL("drop table if exists "+AllTabs.TabNameC);

	}


//	public void close()
//	{
//		DatabaseUtil.closeDataBase(database);
//	}

	public SQLiteDatabase getReadableDatabase()
	{
		database = SQLiteDatabase.openDatabase(DATABASE_FILE_PATH + File.separator + DBName, null, SQLiteDatabase.OPEN_READONLY);
		return database;
	}

	public SQLiteDatabase getWritableDatabase()
	{
		database = SQLiteDatabase.openDatabase(DATABASE_FILE_PATH + File.separator + DBName, null, SQLiteDatabase.OPEN_READWRITE);

		return database;
	}

	public boolean insertSalData(int bn,int sln,String itmnam,double wts,int sbn)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();
		contentValues.put(AllTabs.keya_bn, bn);
		contentValues.put(AllTabs.keya_bnsub, sbn);
		contentValues.put(AllTabs.keya_sln, sln);
		contentValues.put(AllTabs.keya_itmnam, itmnam);
		contentValues.put(AllTabs.keyb_wts, wts);

		long result=db.insert(AllTabs.TabNameA, null, contentValues);
		if(result==-1)
			return false;
		else
			return true;
	}

	public boolean insertBillsData(int bn,String dat,String cstnam,double wts,double perc,double fin,double rat,double totamt,int sbn)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();
		contentValues.put(AllTabs.keyb_bn, bn);
		contentValues.put(AllTabs.keyb_bnsub, sbn);
		contentValues.put(AllTabs.keyb_dat, dat);
		contentValues.put(AllTabs.keyb_cstnam, cstnam);
		contentValues.put(AllTabs.keyb_wts, wts);
		contentValues.put(AllTabs.keyb_perc, perc);
		contentValues.put(AllTabs.keyb_fin, fin);
		contentValues.put(AllTabs.keyb_rat, rat);
		contentValues.put(AllTabs.keyb_totamt, totamt);

		long result=db.insert(AllTabs.TabNameB, null, contentValues);
		if(result==-1)
			return false;
		else
			return true;
	}
	public boolean updateBillsData(int bn,String dat,String cstnam,double wts,double perc,double fin,double rat,double totamt,int sbn)
	{

		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();
		contentValues.put(AllTabs.keyb_bn, bn);
		contentValues.put(AllTabs.keyb_bnsub, sbn);
		contentValues.put(AllTabs.keyb_dat, dat);
		contentValues.put(AllTabs.keyb_cstnam, cstnam);
		contentValues.put(AllTabs.keyb_wts, wts);
		contentValues.put(AllTabs.keyb_perc, perc);
		contentValues.put(AllTabs.keyb_fin, fin);


		String where = AllTabs.keyb_bn+"="+bn+" and "+AllTabs.keyb_bnsub+"="+sbn;
		int x1=db.update(AllTabs.TabNameB, contentValues, where, null);
		if(x1>0)
			return true;
else

		return false;
	}

	public Cursor getAllItmsList(int bn)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keya_bn+"="+bn;
			cr = db.query(AllTabs.TabNameA, SalTabColA, where, null, null, null,AllTabs.keya_bnsub + " asc ");
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public Cursor getTotWts(int bn,int bns)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keya_bn+"="+bn;
			//+" and AllTabs.keya_bnsub="+bns;
			cr = db.query(AllTabs.TabNameA, SalTabColA, where, null, null, null,null);
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public Cursor getAllBillData(int bn,int bns)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keyb_bn+"="+bn+" and "+AllTabs.keyb_bnsub+"="+bns;
			cr = db.query(AllTabs.TabNameB, BilTabColB, where, null, null, null,null);
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public Cursor getAllBillData(int bn)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keyb_bn+"="+bn;
			cr = db.query(AllTabs.TabNameB, BilTabColB, where, null, null, null,null);
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public Cursor getAllNamesInTab()
	{
		SQ=this.getReadableDatabase();
		Cursor cr=null;
		cr = SQ.rawQuery("SELECT * FROM "+AllTabs.TabNameA ,null);
		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public boolean delSalItmByBN(int bno)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keya_bn+"="+bno;
			long k=SQ.delete(AllTabs.TabNameA, where, null);
			if(k>0)
			{
				delBilItmByBN(bno);
				delBilItmC(bno);
				return true;
			}}catch(Exception e){return false;}
		return false;
	}


	public Cursor getAllBillNo(){
		SQLiteDatabase	sqdb=this.getReadableDatabase();//                  1          2              3        4        5       6      7
		//db.query(distinct,        table,      columns,    selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		//                                                  1     2     3    4         6
		Cursor cur=sqdb.query(true,        AllTabs.TabNameA,      SalTabColA,    null, null, AllTabs.keya_bn, null, null, null);
		//Cursor cur= sqdb.query(true,TableName1, ALL_Keys ,	null, null, col2,null, col2 + " asc ",null,null);
		return cur;

	}
	public Cursor getAllBillNoSub(int x){
		SQLiteDatabase	sqdb=this.getReadableDatabase();//                  1          2              3        4        5       6      7
		//db.query(distinct,        table,      columns,    selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		//                                                  1     2     3    4         6
		String where=AllTabs.keya_bn+"="+x;
		Cursor cur=sqdb.query(true,        AllTabs.TabNameA,      SalTabColA,    where, null, AllTabs.keya_bnsub, null, null, null);
		//Cursor cur= sqdb.query(true,TableName1, ALL_Keys ,	null, null, col2,null, col2 + " asc ",null,null);
		return cur;

	}
	public Cursor getNextItmNoInBill(String a,String b)
	{
		int x=Integer.valueOf(a);
		int y=Integer.valueOf(b);

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keya_bn+"="+x+" and "+AllTabs.keya_bnsub+"="+y;
			cr = db.query(AllTabs.TabNameA, SalTabColA, where, null, null, null,AllTabs.keya_sln + " asc ");
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
		return cr;

	}

	public boolean delSalItmBySln(int bn,int sbn,int sln)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keya_bn+" = "+bn+" and "+AllTabs.keya_bnsub+"="+sbn+" and "+AllTabs.keya_sln+"="+sln;
			long k=SQ.delete(AllTabs.TabNameA, where, null);
			if(k>0)
			{
				return true;
			}}catch(Exception e){return false;}
		return false;
	}

	public Cursor getSalItmsList(int bn,int bns)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keya_bn+"="+bn+" and "+AllTabs.keya_bnsub+"="+bns;
			cr = db.query(AllTabs.TabNameA, SalTabColA, where, null, null, null,AllTabs.keya_sln + " asc ");
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public void modifySalItmForSlnRearange(int sln,int ref,int bno,int k)
	{
		int x=0;
		int rf=0;
		rf=Integer.valueOf(ref);
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keya_sln,sln);

		String where = AllTabs.keya_bnsub+"="+k+" and "+AllTabs.keya_bn+"="+bno+" and "+AllTabs.keya_sln+"="+ref;
		int x1=db.update(AllTabs.TabNameA, contentValues, where, null);


	}
	//================================================================
	public Cursor findBnoNListBilTab(int bilno)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keyb_bn+"="+x;
		cr = SQ.query(AllTabs.TabNameB, BilTabColB, where, null, null, null,AllTabs.keyb_bn + " asc ");

		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public boolean delBilItmByBN(int bno)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keyb_bn+"="+bno;
			long k=SQ.delete(AllTabs.TabNameB, where, null);
			if(k>0)
			{
				return true;
			}}catch(Exception e){return false;}
		return false;
	}

	public Cursor findSalsByBn_Sln_Itm(int bilno,int bns,int sln)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keya_bn+"="+bilno+" and "+AllTabs.keya_bnsub+ " ="+bns+" and "+AllTabs.keya_sln+ " ="+sln;
		//+" and "+ AllTabs.keya_itmnam+" ="+itm;
		cr = SQ.query(AllTabs.TabNameA, SalTabColA, where, null, null, null, AllTabs.keya_sln + " asc ");

		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public Cursor findBillByBn_sbn(int bilno,int bns)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keyb_bn+"="+bilno+" and "+AllTabs.keyb_bnsub+ " ="+bns;
		//+" and "+ AllTabs.keya_itmnam+" ="+itm;
		cr = SQ.query(AllTabs.TabNameB, BilTabColB, where, null, null, null, null);

		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public Cursor findBillInfo(int bilno)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keyb_bn+"="+bilno;
		//+" and "+ AllTabs.keya_itmnam+" ="+itm;
		cr = SQ.query(AllTabs.TabNameB, BilTabColB, where, null, null, null, null);

		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public boolean delSal$Edit(int bno,int bns,int sln)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keya_bn+"="+bno+"and "+AllTabs.keya_bnsub+"="+bns+AllTabs.keya_sln+"="+sln;
			long k=SQ.delete(AllTabs.TabNameA, where, null);
			if(k>0)
			{
				return true;
			}}catch(Exception e){return false;}
		return false;
	}

	public boolean editItmWts(int bn,int bns,int sln,double wts)
	{
		boolean b=false;
		int x=0;
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keya_wts,wts);

		String where = AllTabs.keya_bn+"="+bn+" and "+AllTabs.keya_bnsub+"="+bns+" and "+AllTabs.keya_sln+"="+sln;
		int x1=db.update(AllTabs.TabNameA, contentValues, where, null);
		if(x1>0)
			b=true;


		return b;
	}
	public boolean editTotWts(int bn,int bns,double wts)
	{
		boolean b=false;
		int x=0;
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keyb_wts,wts);

		String where = AllTabs.keyb_bn+"="+bn+" and "+AllTabs.keyb_bnsub+"="+bns;
		int x1=db.update(AllTabs.TabNameB, contentValues, where, null);
		if(x1>0)
			b=true;


		return b;


	}
	public boolean editTotRats(int bn,double rat,double tots)
	{
		boolean b=false;
		int x=0;
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keyb_rat,rat);
		contentValues.put(AllTabs.keyb_totamt,tots);

		String where = AllTabs.keyb_bn+"="+bn;
		int x1=db.update(AllTabs.TabNameB, contentValues, where, null);
		if(x1>0)
			b=true;


		return b;


	}
	public Cursor getAllInames(){
		SQLiteDatabase db=this.getReadableDatabase();//           1          2           3        4        5       6      7
		//db.query(distinct,        table,      columns,    selection, selectionArgs, groupBy, having, orderBy, limit, cancellationSignal)
		//                                                  							1     2     3   			 4       6
		Cursor cur=db.query(true, AllTabs.TabNameA, SalTabColA, null, null, AllTabs.keya_itmnam, null, null, null);
		//Cursor cur= sqdb.query(true,TableName1, ALL_Keys ,	null, null, col2,null, col2 + " asc ",null,null);
		return cur;

	}
	public List putINamesInAddopter()
	{
		Cursor c=getAllInames();
		List<String> a_inv = new ArrayList<String>();
		int iCM = c.getColumnIndex(AllTabs.keya_itmnam);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
		{
			a_inv.add(c.getString(iCM));

		}
		return a_inv;
	}

//=======================Payment Service================
	public Cursor getAllBilsList()
	{

	Cursor cr=null;
	SQLiteDatabase db = this.getWritableDatabase();
	try
	{

//		cr = db.query(AllTabs.TabNameB, BilTabColB, null, null, null, null,AllTabs.keyb_bn + " asc ");
		 cr=db.query(true,        AllTabs.TabNameB,      BilTabColB,    null, null, AllTabs.keyb_bn, null, null, null);
		if (cr != null) {cr.moveToFirst();}
		return cr;
	}catch(Exception e)
	{
		Log.d("Expt", e.toString());
		return cr;
	}
	}
	public Cursor getPaidList(int bn)
	{

		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where = AllTabs.keyb_bn+"="+bn;
		cr = db.query(AllTabs.TabNameC, PayTabColC, where, null, null, null,AllTabs.keyc_pid + " asc ");
			if (cr != null) {cr.moveToFirst();}
			return cr;
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
	}
	public boolean insertBillsPay(int bn,double bamt,int pid,String dat,double pamt,double bal) {
		String msg = "Yes";

			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues contentValues = new ContentValues();
			contentValues.put(AllTabs.keyc_bn, bn);
			contentValues.put(AllTabs.keyc_bamt, bamt);
			contentValues.put(AllTabs.keyc_pid, pid);
			contentValues.put(AllTabs.keyc_pdat, dat);
			contentValues.put(AllTabs.keyc_pamt, pamt);
			contentValues.put(AllTabs.keyc_bal, bal);

			long result = db.insert(AllTabs.TabNameC, null, contentValues);

		if(result==-1) {
			Log.d("Expt", "Testingssssssssssssssssssssssssssssssss");
				return false;
		}
		else
			return true;
//		return msg;
	}

	public Cursor getNextPayId(String a)
	{
		int x=Integer.valueOf(a);


		Cursor cr=null;
		SQLiteDatabase db = this.getWritableDatabase();
		try
		{
			String where=AllTabs.keyc_bn+"="+x;
			cr = db.query(AllTabs.TabNameC, PayTabColC, where, null, null, null,AllTabs.keyc_pid + " asc ");
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
		return cr;

	}
	public boolean delPaidItm(int bn,int pid)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keyc_bn+" = "+bn+" and "+AllTabs.keyc_pid+" = "+pid;
			long k=SQ.delete(AllTabs.TabNameC, where, null);
			if(k>0)
			{
				return true;
			}}catch(Exception e){return false;}
		return false;
	}
	public boolean updatePay(int bn,double bal)
	{
		boolean b=false;
		int x=0;
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keyb_totamt,bal);

		String where = AllTabs.keyb_bn+"="+bn;
		int x1=db.update(AllTabs.TabNameB, contentValues, where, null);
		if(x1>0)
			b=true;


		return b;


	}
	public Cursor getNextItmNoInBill(String a)
	{
		int x=0;
		try{x=Integer.valueOf(a);}catch (Exception e){}
		Cursor cr=null;
		SQLiteDatabase db=this.getWritableDatabase();
		try
		{
			String where=AllTabs.keyc_bn+"="+x;
			cr = db.query(AllTabs.TabNameC, PayTabColC, where, null, null, null,AllTabs.keyc_pid + " asc ");
		}catch(Exception e)
		{
			Log.d("Expt", e.toString());
			return cr;
		}
		return cr;

	}
	public void modifySalItmForSlnRearange(int sln,int ref,int bno)
	{
		int x=0;
		int rf=0;
		rf=Integer.valueOf(ref);

		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues contentValues=new ContentValues();

		contentValues.put(AllTabs.keyc_pid,sln);

		String where = AllTabs.keyc_bn+"="+bno+" and "+AllTabs.keyc_pid+"="+ref;
		int x1=db.update(AllTabs.TabNameC, contentValues, where, null);


	}
	public Cursor findBnoPayTab(int bilno)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keyc_bn+"="+x;
		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public Cursor findPaid(int bilno)
	{
		String x=String.valueOf(bilno);
		SQ=this.getWritableDatabase();
		Cursor cr=null;

		String where=AllTabs.keyc_bn+"="+x;
		cr = SQ.query(AllTabs.TabNameC, PayTabColC, where, null, null, null,AllTabs.keyc_pid + " asc ");
		if (cr != null) {cr.moveToFirst();}
		return cr;
	}
	public boolean delBilItmC(int bno)
	{

		SQ=this.getWritableDatabase();
		try{
			String where=AllTabs.keyc_bn+"="+bno;
			long k=SQ.delete(AllTabs.TabNameC, where, null);
			if(k>0)
			{
				return true;
			}}catch(Exception e){return false;}
		return false;
	}

}
