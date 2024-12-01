package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AngelOfLibraCharityParty extends BuffSkill {
    public AngelOfLibraCharityParty(Long mainStat) {
        this.setName("엔젤 오브 리브라(자애의 천사, 파티)");
        this.setDuration(4L);
        this.setCooldown(5.0);
        this.setApplyServerLag(true);
        this.setPartyBuff(true);
        this.setBuffDamage(5 + 35L);
        /*if (mainStat >= 43750) {
            this.setBuffDamage(5 + 35L);
        } else if (mainStat == 0) {
            this.setBuffDamage(0L);
        } else {
            this.setBuffDamage(5 + mainStat / 1250);
        }*/
    }
}
