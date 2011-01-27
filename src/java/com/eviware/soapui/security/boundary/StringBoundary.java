/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */
package com.eviware.soapui.security.boundary;
/**
 * @author nebojsa.tasic
 */
public class StringBoundary extends AbstractBoundary
{
	private static final String AVAILABLE_VALUES = " abcdefghijklmnopqrstuvwxyz";

	public StringBoundary( String length, String minLength, String maxLength )
	{
		super( length, minLength, maxLength, null, null );
	}

	@Override
	public String outOfBoundary( int restrictionAttribute )
	{
		switch( restrictionAttribute )
		{
		case LENGTH :
			return BoundaryUtils.createCharacterArray( AVAILABLE_VALUES, Integer.valueOf( length ) );
		case MIN_LENGTH :
			return BoundaryUtils.createCharacterArray( AVAILABLE_VALUES, Integer.valueOf( minLength ) - 1 );
		case MAX_LENGTH :
			return BoundaryUtils.createCharacterArray( AVAILABLE_VALUES, Integer.valueOf( maxLength ) - 1 );
		default :
			return null;
		}
	}

}