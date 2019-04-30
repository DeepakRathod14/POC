/*
 *
 */
package com.rrm.utility.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * The Class DbManager will help to execute all DB queries, SP and it will return its result
 * based on result resultSet will fill and return values.
 *
 * @author Deepak.Rathod
 */
public class DbManager
{

	/** The logger. */
	Logger logger = Logger.getLogger(DbManager.class.getName());

	/**
	 * Gets the hash map.
	 *
	 * @author P00251
	 * @param rsSubItemType the rs sub item type
	 * @return List<Map<String, Object>> which contains ResultSet
	 */
	protected synchronized List<Map<String, Object>> getHashMap(ResultSet rsSubItemType)
	{

		List<Map<String, Object>> row = new ArrayList<>();

		try
		{

			ResultSetMetaData metaData = rsSubItemType.getMetaData();
			int colCount = metaData.getColumnCount();

			while (rsSubItemType.next())
			{
				Map<String, Object> columns = new HashMap<>();
				for (int i = 1; i <= colCount; i++)
				{
					columns.put(metaData.getColumnLabel(i), rsSubItemType.getObject(i));
				}
				row.add(columns);
			}
			return row;
		}
		catch (SQLException se)
		{
			logger.error("SQLException accured While filling result Set HasMap ", se);
		}
		catch (Exception e)
		{
			logger.error(null, e);
		}
		return row;
	}

	/**
	 * Gets the result.
	 *
	 * @author P00251
	 * @param sql Query
	 * @param params the params
	 * @return value From First column and First Row
	 */
	public synchronized Object getResult(String sql, Object... params)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getObject(1);
			} else {
				return null;
			}
		}
		catch (SQLException se)
		{
			logger.error("SQLException accured in getResult() method:", se);

		}
		catch (Exception e)
		{
			logger.error(null, e);

		}
		finally
		{
			ConnectionManager.closeDbConnection(con);
			if (pstmt != null) {
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					logger.error(null, e);
				}
			}
		}
		return null;
	}

	/**
	 * It execute given sql query and Gets the list of result.
	 *
	 * @author P00251
	 * @param sql the sql
	 * @param params the params
	 * @return the list of result
	 */
	public synchronized Object getListofResult(String sql, Object... params)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Object> listofResult = new ArrayList<>();
			while (rs.next())
			{
				listofResult.add(rs.getObject(1));
			}

			return listofResult;
		}
		catch (SQLException se)
		{
			logger.error("SQLException accured in getResult() method:", se);

		}
		catch (Exception e)
		{
			logger.error(null, e);

		}
		finally
		{
			ConnectionManager.closeDbConnection(con);
			if (pstmt != null) {
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					logger.error(null, e);
				}
			}
		}
		return null;
	}


	/**
	 * Gets the result set.
	 *
	 * @author P00251
	 * @param sql the sql
	 * @param params the params
	 * @return List<Map<String, Object>> with ResultSet.
	 */
	public synchronized List<Map<String, Object>> getResultSet(String sql, Object... params)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			ResultSet rs = pstmt.executeQuery();

			return getHashMap(rs);
		}
		catch (SQLException se)
		{
			logger.error("SQLException accured in getResultSet() method:", se);
		}
		catch (Exception e)
		{
			logger.error(null, e);
		}
		finally
		{
			ConnectionManager.closeDbConnection(con);
			try
			{
				if (pstmt != null) {
					pstmt.close();
				}
			}
			catch (SQLException e)
			{
				logger.error(null, e);
			}
		}
		return getHashMap(null);
	}

	/**
	 * Verify DB entry.
	 *
	 * @author P00251
	 * @param columnAndValue the column and value
	 * @param sql the sql
	 * @param params the params
	 * @return true, if successful
	 */
	public boolean verifyDBEntry(Map<String, String> columnAndValue, String sql, Object... params)
	{
		List<Map<String, Object>> result = getResultSet(sql, params);

		if (!result.isEmpty())
		{
			Iterator<String> i = columnAndValue.keySet().iterator();
			while (i.hasNext())
			{
				String column = i.next();
				String value = columnAndValue.get(column);
				String actualVal = result.get(0).get(column).toString().trim();
				if (!(actualVal.equals(value.trim())))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			logger.info("result not Found");
			return false;
		}
	}

}
