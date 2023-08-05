package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AngelOfLibraCharity extends BuffSkill {
    public AngelOfLibraCharity(Long mainStat) {
        this.setName("엔젤 오브 리브라(자애의 천사)");
        this.setDuration(4L);
        this.setCooldown(5.0);
        if (mainStat >= 118750) {
            this.setBuffDamage(5 + 95L);
        } else if (mainStat == 0) {
            this.setBuffDamage(0L);
        } else {
            this.setBuffDamage(5 + mainStat / 1250);
        }
    }
}
