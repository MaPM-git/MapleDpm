package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagicDebris extends AttackSkill {
    public MagicDebris() {
        this.setName("마법 잔해");
        //this.setAddDamage(22L);         // 다크 포그
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }

    public void setByCnt(Long cnt) {
        if (cnt == 15) {
            this.setDamage(427.0 + 353 * 3);
        } else if (cnt >= 10) {
            this.setDamage(427.0 + 353 * 2);
        } else if (cnt >= 5) {
            this.setDamage(427.0 + 353);
        } else {
            this.setDamage(427.0);
        }
        this.setAttackCount(cnt);
    }
}
