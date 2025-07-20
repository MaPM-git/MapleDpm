package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Soulshatter2ChainSlash extends AttackSkill {
    public Soulshatter2ChainSlash() {
        this.setName("망혼검 2초식 : 연참");
        this.setAttackCount(2L);
        this.setDamage(325.0);
        this.setProp(62L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
