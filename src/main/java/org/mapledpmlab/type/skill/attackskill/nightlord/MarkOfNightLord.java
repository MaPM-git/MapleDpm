package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfNightLord extends AttackSkill {
    public MarkOfNightLord() {
        this.setName("마크 오브 나이트로드");
        this.setAttackCount(3L);
        this.setDamage(360.0);
        this.setProp(62L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
