package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BombPunch extends AttackSkill {
    public BombPunch() {
        this.setName("폭류권");
        this.setDamage(304.0);
        this.setAttackCount(3L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
    }
}
