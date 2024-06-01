package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriflingWhim extends AttackSkill {
    public TriflingWhim() {
        this.setName("트라이플링 윔");
        this.setAttackCount(1L);        // 트라이플링 윔-더블 찬스
        this.setDamage(525.0);
        this.setProp(50L + 10);         // 트라이플링 윔-인핸스
        this.setFinalAttack(true);
        this.setAddDamage(20L);         // 트라이플링 윔-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
