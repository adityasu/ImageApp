/* 
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */
package com.demo.imagesearchapp.dataclasses
import com.google.gson.annotations.SerializedName

data class Data (

	@SerializedName("id") val id : String,
	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("datetime") val datetime : Int,
	@SerializedName("cover") val cover : String,
	@SerializedName("cover_width") val cover_width : Int,
	@SerializedName("cover_height") val cover_height : Int,
	@SerializedName("account_url") val account_url : String,
	@SerializedName("account_id") val account_id : Int,
	@SerializedName("privacy") val privacy : String,
	@SerializedName("layout") val layout : String,
	@SerializedName("views") val views : Int,
	@SerializedName("link") val link : String,
	@SerializedName("ups") val ups : Int,
	@SerializedName("downs") val downs : Int,
	@SerializedName("points") val points : Int,
	@SerializedName("score") val score : Int,
	@SerializedName("is_album") val is_album : Boolean,
	@SerializedName("vote") val vote : String,
	@SerializedName("favorite") val favorite : Boolean,
	@SerializedName("nsfw") val nsfw : Boolean,
	@SerializedName("section") val section : String,
	@SerializedName("comment_count") val comment_count : Int,
	@SerializedName("favorite_count") val favorite_count : Int,
	@SerializedName("topic") val topic : String,
	@SerializedName("topic_id") val topic_id : Int,
	@SerializedName("images_count") val images_count : Int,
	@SerializedName("in_gallery") val in_gallery : Boolean,
	@SerializedName("is_ad") val is_ad : Boolean,
	@SerializedName("tags") val tags : List<Tags>,
	@SerializedName("ad_type") val ad_type : Int,
	@SerializedName("ad_url") val ad_url : String,
	@SerializedName("in_most_viral") val in_most_viral : Boolean,
	@SerializedName("include_album_ads") val include_album_ads : Boolean,
	@SerializedName("images") val images : List<Images>,
	@SerializedName("ad_config") val ad_config : Ad_config
)