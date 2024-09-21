package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Sylphidia extends BuffSkill {
    public Sylphidia() {
        this.setName("실피디아");
        this.setDelay(690L);
        this.setCooldown(90.0);
        this.setDuration(25L);
        this.addBuffAttMagicPer(20L);
        this.addBuffFinalDamage(1.05);      // 코어 강화
        this.setApplyServerLag(true);
    }
}
