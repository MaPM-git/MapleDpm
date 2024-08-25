package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CircleOfMana2Cancel extends AttackSkill {
    public CircleOfMana2Cancel() {
        this.setName("서클 오브 마나(2타, 캔슬)");
        this.setDamage(625.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(240L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        //this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
