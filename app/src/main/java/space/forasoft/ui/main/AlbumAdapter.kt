package space.forasoft.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.forasoft.R
import space.forasoft.models.Album

class AlbumAdapter(val data: List<Album>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlbumListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_album, parent, false)
        )
    }
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val albumViewHolder = holder as AlbumListViewHolder
        albumViewHolder.bindView(data[position])
    }
}
