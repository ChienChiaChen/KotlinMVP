package com.chiachen.kotlinmvp.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.chiachen.kotlinmvp.Injector
import com.chiachen.kotlinmvp.R
import com.chiachen.kotlinmvp.data.api.model.SourceResponse
import com.chiachen.kotlinmvp.data.source.SourceRepository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), SourceContract.View  {

    @Inject lateinit var repository : SourceRepository
    private lateinit var presenter : SourceContract.Presenter
    private val adapter = SourceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(this.toolbar)
        Injector.obtain(this)!!.inject(this)
        SourcePresenter(this, repository)

        adapter.setClickListener(object: SourceAdapter.ItemClickListener {
            override fun onItemClickListener(item: SourceResponse.Sources) {
            }
        })

        this.list.adapter = adapter
        this.list.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        presenter.start()
    }

    override fun setPresenter(presenter: SourceContract.Presenter) {
        this.presenter = presenter
    }

    override fun updateView(list: SourceResponse) {
        adapter.clearItems()
        adapter.setItems(list.sources)
    }
}
