package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfAssassin extends AttackSkill {
    public MarkOfAssassin() {
        this.setName("마크 오브 어쌔신");
        this.setAttackCount(3L);
        this.setDamage(615.0);
        this.setProp(39L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
