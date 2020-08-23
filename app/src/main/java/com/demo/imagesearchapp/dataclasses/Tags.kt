/* 
Copyright (c) 2020 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */
package com.demo.imagesearchapp.dataclasses
import com.google.gson.annotations.SerializedName

data class Tags (

	@SerializedName("name") val name : String,
	@SerializedName("display_name") val display_name : String,
	@SerializedName("followers") val followers : Int,
	@SerializedName("total_items") val total_items : Int,
	@SerializedName("following") val following : Boolean,
	@SerializedName("is_whitelisted") val is_whitelisted : Boolean,
	@SerializedName("background_hash") val background_hash : String,
	@SerializedName("thumbnail_hash") val thumbnail_hash : String,
	@SerializedName("accent") val accent : String,
	@SerializedName("background_is_animated") val background_is_animated : Boolean,
	@SerializedName("thumbnail_is_animated") val thumbnail_is_animated : Boolean,
	@SerializedName("is_promoted") val is_promoted : Boolean,
	@SerializedName("description") val description : String,
	@SerializedName("logo_hash") val logo_hash : String,
	@SerializedName("logo_destination_url") val logo_destination_url : String,
	@SerializedName("description_annotations") val description_annotations : Description_annotations
)