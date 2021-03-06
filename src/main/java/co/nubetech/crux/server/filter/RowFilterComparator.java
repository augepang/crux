/**
 * Copyright 2011 Nube Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package co.nubetech.crux.server.filter;

import java.util.Comparator;

import co.nubetech.crux.model.RowAlias;
import co.nubetech.crux.model.RowAliasFilter;

/**
 * This class is used to sort the row filters by the id of the RowAlias.
 * 
 * @author sgoyal
 * 
 */
public class RowFilterComparator implements Comparator<RowAliasFilter> {

	public int compare(RowAliasFilter filter1, RowAliasFilter filter2) {
		int comparison = 0;
		if (filter1 != null) {
			if (filter2 != null) {
				RowAlias alias1 = filter1.getRowAlias();
				RowAlias alias2 = filter2.getRowAlias();
				if (alias1 != null) {
					if (alias2 != null) {
						long id1 = alias1.getId();
						long id2 = alias2.getId();
						if (id1 < id2) {
							comparison = -1;
						} else if (id1 > id2) {
							comparison = 1;
						} else {
							comparison = 0;
						}
					} else {
						comparison = 1;
					}
				} else if (alias2 != null) {
					comparison = -1;
				} else {
					comparison = 0;
				}
			} else {
				comparison = 1;
			}
		} else if (filter2 != null) {
			comparison = -1;
		} else {
			comparison = 0;
		}
		return comparison;
	}

}
