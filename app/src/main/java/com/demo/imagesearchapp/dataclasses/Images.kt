/* 
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */
package com.demo.imagesearchapp.dataclasses
import com.google.gson.annotations.SerializedName

data class Images (

	@SerializedName("id") val id : String,
	@SerializedName("title") val title : String,
	@SerializedName("description") val description : String,
	@SerializedName("datetime") val datetime : Int,
	@SerializedName("type") val type : String,
	@SerializedName("animated") val animated : Boolean,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("size") val size : Int,
	@SerializedName("views") val views : Int,
	@SerializedName("bandwidth") internal val bandwidth: Long,
	@SerializedName("vote") val vote : String,
	@SerializedName("favorite") val favorite : Boolean,
	@SerializedName("nsfw") val nsfw : String,
	@SerializedName("section") val section : String,
	@SerializedName("account_url") val account_url : String,
	@SerializedName("account_id") val account_id : String,
	@SerializedName("is_ad") val is_ad : Boolean,
	@SerializedName("in_most_viral") val in_most_viral : Boolean,
	@SerializedName("has_sound") val has_sound : Boolean,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("ad_type") val ad_type : Int,
	@SerializedName("ad_url") val ad_url : String,
	@SerializedName("edited") val edited : Int,
	@SerializedName("in_gallery") val in_gallery : Boolean,
	@SerializedName("link") val link : String,
	@SerializedName("comment_count") val comment_count : String,
	@SerializedName("favorite_count") val favorite_count : String,
	@SerializedName("ups") val ups : String,
	@SerializedName("downs") val downs : String,
	@SerializedName("points") val points : String,
	@SerializedName("score") val score : String
)