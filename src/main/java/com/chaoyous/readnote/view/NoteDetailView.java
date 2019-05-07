package com.chaoyous.readnote.view;

import com.chaoyous.readnote.entity.DiscussEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Demo class
 *
 * @author zcj
 * @date 2019/5/7
 */
@AllArgsConstructor
@Data
public class NoteDetailView {
    private ExploreView exploreModel;
    private List<DiscussEntity> discussList;
}
