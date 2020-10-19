package space.forasoft.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import space.forasoft.R

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() = AlbumsFragment()
    }

    private lateinit var viewModel: AlbumsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlbumsViewModel::class.java)

        rv_main.layoutManager = GridLayoutManager(requireContext(), 2)

        val largePadding = 16
        val smallPadding = 8
        rv_main.addItemDecoration(AlbumGridItemDecoration(largePadding, smallPadding))

        viewModel.albumListData.observe(viewLifecycleOwner, Observer {
            rv_main.adapter = AlbumAdapter(it)
        })

        bt_search.setOnClickListener {
            val inputText = et_search.editText?.text.toString()
            viewModel.load(inputText)
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}