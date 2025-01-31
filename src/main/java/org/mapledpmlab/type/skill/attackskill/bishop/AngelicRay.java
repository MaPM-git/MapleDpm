package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AngelicRay extends AttackSkill {
    public AngelicRay() {
        this.setName("엔젤레이");
        this.setDamage(355.0 + 20);
        this.setAttackCount(14L);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
