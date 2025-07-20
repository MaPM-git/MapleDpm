package org.mapledpmlab.type.skill.attackskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

@Getter
@Setter
public class SylphidiaAfterImage extends AttackSkill {
    public SylphidiaAfterImage() {
        this.setName("실피디아(잔상)");
        this.setDamage(1320.0);
        this.setAttackCount(4L);
        this.addFinalDamage(1.6);           // 코어 강화
        for (int i = 0; i < 7; i++) {
            this.getMultiAttackInfo().add(210L);
        }
    }
}
