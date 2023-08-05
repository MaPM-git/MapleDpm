package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossReuse;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.NatureFriend;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

public class Lara extends Job {

    public Lara() {
        // 기본
        super();
        this.setDescription("라라");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new PassiveBossReuse());
        this.addObject(new ReuseFarm());
        this.addObject(new PhantomInstinct());
        this.addObject(new NatureFriend());
        this.addObject(new IntUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (400 + 246 + 72 + 274));
        this.setWeaponAttMagic((long) (400 + 246 + 72 + 274));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addMagic(3L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 2차
        this.addMagic(35L);             // 지팡이 숙련
        this.addMainStat(40L);          // 신체 단련

        // 3차
        this.addDamage(20L);            // 무구
        this.addBossDamage(10L);
        this.addCriticalP(20.0);

        // 4차
        this.addFinalDamage(1.3);       // 고급 지팡이 숙련
        this.addMagic(51L);
        this.addCriticalP(21.0);        // 혜안
        this.addCriticalDamage(21.0);
        this.addFinalDamage(1.46);
        this.addIgnoreDefenseList(41L);

        // 5차
        this.addMainStat(30L);          // 언스태이블 메모라이즈
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
