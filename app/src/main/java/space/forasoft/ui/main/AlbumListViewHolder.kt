package space.forasoft.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import space.forasoft.models.Album
import kotlinx.android.synthetic.main.item_grid_album.view.*
import space.forasoft.R

class AlbumListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindView(album: Album) {
        itemView.tv_artistName.text = album.artist
        itemView.tv_AlbumTitle.text = album.descrAlbum

        itemView.imageAlbum.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", album.albumId)
            itemView.findNavController().navigate(R.id.albumDetail, bundle)
        }

        Glide.with(itemView.context)
            .load(album.imgAlbum.replace("100x100bb","200x200bb"))
            .into(itemView.imageAlbum)
    }
}