package space.forasoft.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_songs.view.*
import space.forasoft.models.Songs
import java.util.concurrent.TimeUnit

class SongsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(songs: Songs) {
        itemView.tv_track_number.text = songs.trackNumber
        itemView.tv_track_name.text = songs.trackName
        itemView.tv_track_time.text = dateFormat(songs.trackTimeMillis)
    }

    fun dateFormat(m: Long) : String {
        return String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(m),
            TimeUnit.MILLISECONDS.toMinutes(m) -
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(m)),
            TimeUnit.MILLISECONDS.toSeconds(m) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(m))
        )
    }
}