package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PeacemakerBuff extends BuffSkill {
    public PeacemakerBuff() {
        this.setName("피스메이커(신성한 빛)");
        this.setBuffDamage(23L);
        this.setDuration(12L);
        this.setApplyServerLag(true);
    }
}
