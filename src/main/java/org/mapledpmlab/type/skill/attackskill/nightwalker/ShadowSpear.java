package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.DominionBuff;

public class ShadowSpear extends AttackSkill {
    public ShadowSpear() {
        this.setName("쉐도우 스피어");
        this.setAttackCount(2L);
        this.setDamage(415.0);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
