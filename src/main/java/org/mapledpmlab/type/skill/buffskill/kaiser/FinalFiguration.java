package org.mapledpmlab.type.skill.buffskill.kaiser;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FinalFiguration extends BuffSkill {
    public FinalFiguration() {
        this.setName("파이널 피규레이션");
        this.setDuration(60L);
        this.setBuffFinalDamage(1.15);
        this.setApplyPlusBuffDuration(true);
    }
}
