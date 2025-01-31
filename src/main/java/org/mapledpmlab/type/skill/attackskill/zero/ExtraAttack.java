package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ExtraAttack extends AttackSkill {
    public ExtraAttack() {
        this.setName("초월자 륀느의 기원(추가 타격)");
        this.setAttackCount(5L);
        this.setDamage(365.0);
        this.getMultiAttackInfo().add(120L);
    }
}
