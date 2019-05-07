package com.chaoyous.readnote.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/6
 */
@Data
@AllArgsConstructor
public class ExploreListView {
    List<ExploreView> exploreViewList;
}
