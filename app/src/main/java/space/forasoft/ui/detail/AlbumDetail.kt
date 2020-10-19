package space.forasoft.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.album_detail_fragment.*
import space.forasoft.R
import space.forasoft.models.AlbumInfo
import java.util.*

class AlbumDetail : Fragment() {

    companion object {
        fun newInstance() = AlbumDetail()
    }

    private lateinit var viewModel: AlbumDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.album_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlbumDetailViewModel::class.java)

        val t = arguments?.getString("id")
        viewModel.load(t!!)

        rv_detail.layoutManager = LinearLayoutManager(requireContext())

        rv_detail.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        viewModel.songListData.observe(viewLifecycleOwner, Observer {
            rv_detail.adapter = SongsAdapter(it)
        })

        viewModel.albumInfo.observe(viewLifecycleOwner, {
            bindAlbumInfo(it)
        })
    }

    private fun bindAlbumInfo(list: List<AlbumInfo>) {
        tv_detail_artist.text = list[0].artistName
        tv_detail_descrAlbum.text = list[0].collectionName

        val year = getYear(list[0].releaseDate)

        tv_detail_genre_and_year.text = "${list[0].primaryGenreName} · $year"
        Glide.with(this)
            .load(list[0].artworkUrl100.replace("100x100bb","200x200bb"))
            .into(iv_detail_imgAlbum)
    }

    fun getYear(d: Date): Int {
        val cal = Calendar.getInstance()
        cal.setTime(d)
        return cal.get(Calendar.YEAR)
    }
}