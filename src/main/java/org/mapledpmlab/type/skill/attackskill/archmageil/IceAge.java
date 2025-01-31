package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceAge extends AttackSkill {
    public IceAge() {
        this.setName("아이스 에이지");
        this.setDamage(1100.0);
        this.setAttackCount(10L);
        this.setDelayByAttackSpeed(870L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);           // 코어강화
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
