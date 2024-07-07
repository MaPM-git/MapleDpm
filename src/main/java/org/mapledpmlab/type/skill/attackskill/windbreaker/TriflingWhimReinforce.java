package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriflingWhimReinforce extends AttackSkill {
    public TriflingWhimReinforce() {
        this.setName("트라이플링 윔(강화)");
        this.setAttackCount(1L);        // 트라이플링 윔-더블 찬스
        this.setDamage(750.0);
        this.setProp(20L);
        this.setFinalAttack(true);
        this.setAddDamage(20L);         // 트라이플링 윔-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
