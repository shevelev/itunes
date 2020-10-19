package space.forasoft.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.forasoft.R
import space.forasoft.models.Songs

class SongsAdapter(private val data: List<Songs>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SongsListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_songs, parent, false)
        )
    }
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val songsViewHolder = holder as SongsListViewHolder
        songsViewHolder.bindView(data[position])
    }
}
