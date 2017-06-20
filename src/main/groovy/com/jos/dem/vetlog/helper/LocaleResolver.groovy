/*
Copyright 2017 José Luis De la Cruz Morales joseluis.delacruz@gmail.com

Licensed under the Apache License, Version 2.0 (the "License")
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.jos.dem.vetlog.helper

import org.springframework.stereotype.Component
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver

import javax.servlet.http.HttpServletRequest

@Component
class LocaleResolver extends AcceptHeaderLocaleResolver{

  private static final List<Locale> LOCALES = [new Locale("en"), new Locale("es")]

  @Override
  Locale resolveLocale(HttpServletRequest request) {
    if (!request.getHeader('Accept-Language')) {
      return Locale.getDefault()
    }
    List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"))
    Locale locale = Locale.lookup(list, LOCALES)
    return locale
  }

}

