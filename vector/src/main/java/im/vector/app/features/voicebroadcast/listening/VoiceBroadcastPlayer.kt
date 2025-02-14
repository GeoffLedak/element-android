/*
 * Copyright (c) 2022 New Vector Ltd
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

package im.vector.app.features.voicebroadcast.listening

import im.vector.app.features.voicebroadcast.model.VoiceBroadcast

interface VoiceBroadcastPlayer {

    /**
     * The current playing voice broadcast, if any.
     */
    val currentVoiceBroadcast: VoiceBroadcast?

    /**
     * The current playing [State], [State.IDLE] by default.
     */
    val playingState: State

    /**
     * Start playback of the given voice broadcast.
     */
    fun playOrResume(voiceBroadcast: VoiceBroadcast)

    /**
     * Pause playback of the current voice broadcast, if any.
     */
    fun pause()

    /**
     * Stop playback of the current voice broadcast, if any, and reset the player state.
     */
    fun stop()

    /**
     * Seek the given voice broadcast playback to the given position, is milliseconds.
     */
    fun seekTo(voiceBroadcast: VoiceBroadcast, positionMillis: Int, duration: Int)

    /**
     * Add a [Listener] to the given voice broadcast.
     */
    fun addListener(voiceBroadcast: VoiceBroadcast, listener: Listener)

    /**
     * Remove a [Listener] from the given voice broadcast.
     */
    fun removeListener(voiceBroadcast: VoiceBroadcast, listener: Listener)

    /**
     * Player states.
     */
    enum class State {
        PLAYING,
        PAUSED,
        BUFFERING,
        IDLE
    }

    /**
     * Listener related to [VoiceBroadcastPlayer].
     */
    fun interface Listener {
        /**
         * Notify about [VoiceBroadcastPlayer.playingState] changes.
         */
        fun onStateChanged(state: State)
    }
}
