/*
 * Copyright 2015 Gunnar Kappei.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.moosbusch.permagon.application;

import java.net.URL;
import java.util.Collection;

/**
 *
 * @author Gunnar Kappei
 * @param <T> The main application-context
 */
public interface PermagonApplication<T extends PermagonApplicationContext> {

    public static final String PRIMARY_SCENE_QUALIFIER = "primaryScene";

    public boolean canCloseStage();

    public Collection<Class<?>> getBeanConfigurationClasses();

    public Collection<String> getBeanConfigurationPackages();

    public URL getFXMLConfigurationFile();

    public T getApplicationContext();

}
