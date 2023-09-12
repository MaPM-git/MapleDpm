package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.DominionBuff;

public class ShadowBite extends AttackSkill implements DarkAttack {
    public ShadowBite() {
        this.setName("쉐도우 바이트");
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(14L);
        this.setDamage(1485.0);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
