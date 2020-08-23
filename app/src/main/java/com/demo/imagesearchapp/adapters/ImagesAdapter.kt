package com.demo.imagesearchapp.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.demo.imagesearchapp.R
import com.demo.imagesearchapp.activities.SecondActivity
import com.demo.imagesearchapp.databasehelper.DBHelper
import com.demo.imagesearchapp.dataclasses.Data

class ImagesAdapter(val data: List<Data>?) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    var mData : List<Data>? = data
    lateinit var context : Context

     constructor (data: List<Data>?, context_: Context): this(data) {
        this.mData = data
        this.context = context_
    }

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView){
        val imageView = itemView.findViewById<ImageView>(R.id.info_image)
        val imageTitle = itemView.findViewById<TextView>(R.id.image_title)
        val imageID = itemView.findViewById<TextView>(R.id.image_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val dataView = inflater.inflate(R.layout.images_grid_item_view, parent, false)
        return ViewHolder(dataView)
    }

    override fun onBindViewHolder(holder: ImagesAdapter.ViewHolder, position: Int) {
        val data : Data? = mData?.get(position)
        val image = holder.imageView
        val title = holder.imageTitle
        val id = holder.imageID
        if(shouldLoadImage(data)) {
            val DBHelper : DBHelper = DBHelper(context)
            val uri : Uri = Uri.parse(data?.images?.get(0)?.link)
            Log.e("ImageApapter", " $uri $position")
            Glide.with(this.context)
                .load(uri)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image)
            DBHelper.insertImages(data?.id)
        }
        else {
            image.setImageResource(R.drawable.no_img_available)
        }
        //image.setImageBitmap(uri)
        title.text = String.format("%s%s",this.context.getString(R.string.title_string) , data?.title)
        id.text = String.format("%s%s",this.context.getString(R.string.id_string) , data?.id)

        holder.imageView.setOnClickListener(View.OnClickListener {
            if(shouldLoadImage(data)) {
                Toast.makeText(context, "clicked on image  " + data?.id, Toast.LENGTH_LONG).show()
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("image_url", data?.images?.get(0)?.link)
                intent.putExtra("image_id", data?.id)
                intent.putExtra("image_title", data?.title)
                this.context.startActivity(intent)
            } else {
                Toast.makeText(context, "Unable to open image details view as no image available  " + data?.id, Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun getItemCount(): Int {
        return mData?.size!!
    }

    private fun shouldLoadImage(data: Data?) : Boolean {
        return (data?.is_album != false && (data?.images?.get(0)?.link?.contains(".mp4") == false))
    }
}