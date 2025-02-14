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

package im.vector.app.features.settings.devices.v2.notification

import androidx.lifecycle.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import org.matrix.android.sdk.api.session.Session
import org.matrix.android.sdk.flow.unwrap
import javax.inject.Inject

class CanTogglePushNotificationsViaPusherUseCase @Inject constructor() {

    fun execute(session: Session): Flow<Boolean> {
        return session
                .homeServerCapabilitiesService()
                .getHomeServerCapabilitiesLive()
                .asFlow()
                .unwrap()
                .map { it.canRemotelyTogglePushNotificationsOfDevices }
                .distinctUntilChanged()
    }
}
