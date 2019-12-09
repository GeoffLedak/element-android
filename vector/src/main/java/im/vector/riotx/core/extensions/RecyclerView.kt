/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.core.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyController

/**
 * Apply a Vertical LinearLayout Manager to the recyclerView and set the adapter from the epoxy controller
 */
fun RecyclerView.configureWith(epoxyController: EpoxyController,
                               itemAnimator: RecyclerView.ItemAnimator? = null,
                               itemDecoration: RecyclerView.ItemDecoration? = null,
                               hasFixedSize: Boolean = true) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    itemAnimator?.let { this.itemAnimator = it }
    itemDecoration?.let { addItemDecoration(it) }
    setHasFixedSize(hasFixedSize)
    adapter = epoxyController.adapter
}

/**
 * To call from Fragment.onDestroyView()
 */
fun RecyclerView.cleanup() {
    adapter = null
}
