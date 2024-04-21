package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossCritical;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperDemonAvenger;
import org.mapledpmlab.type.link.IronWill;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DemonAvengerUnion;

import java.util.stream.Collectors;

public class DemonAvenger extends Job {
    private Long starforce = 0L;

    public DemonAvenger() {
        // 기본
        super();
        this.setName("데몬어벤져");
        this.setConstant(1.3);          // 무기상수
        this.setMainStat((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        this.setMastery(1.91 / 2);      // 숙련도
        this.addMainStatP(10L);         // 4카루타 세트
        this.setJobType(JobType.DEMON_AVENGER);

        this.addPerXMainStat(-28200L);
        this.addPerXMainStat(277200L + 315000);

        this.starforce += 22 * 16;      // 22성 장비
        this.starforce += 15;           // 블랙하트
        if (this.starforce >= 361 && this.starforce <= 370) {
            this.addHp(this.starforce * 160);
        } else if (this.starforce >= 371 && this.starforce <= 380) {
            this.addHp(this.starforce * 162);
        } else if (this.starforce >= 381 && this.starforce <= 390) {
            this.addHp(this.starforce * 164);
        } else if (this.starforce >= 391 && this.starforce <= 400) {
            this.addHp(this.starforce * 166);
        } else if (this.starforce >= 401) {
            this.addHp(this.starforce * 168);
        }

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (145));
        this.addHp((long) (2800 + 1855) / 2);
        this.addAtt((long) (340 + 210 + 72 + 253));
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addHp(560L / 2);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addFinalDamage(1.1);

        // 1차
        this.addCriticalP(15.0);        // 데모닉 샤프니스

        // 2차
        this.addHp(400L);               // 데몬 액셀레이션
        this.addAtt(40L);               // 어비셜 레이지
        this.addCriticalP(20.0);
        this.addHp(600L);               // 이너 스트렝스

        // 3차
        this.addMainStatP(25L);         // 디아볼릭 리커버리

        // 4차
        this.addMainStatP(15L);         // 메이플 용사
        this.addFinalDamage(1.15);      // 오버휄밍 파워
        this.addDamage(31L);
        this.addIgnoreDefenseList(31L);  // 디펜스 엑스퍼타이즈
        this.addAtt(51L);               // 어드밴스드 데스페라도 마스터리
        this.addCriticalDamage(1.08);

        // 5차
        this.addHp(1500L);              // 바디 오브 스틸
        this.addFinalDamage(1.2);       // 데몬 프렌지
        this.addMainStatP(40L);         // 쓸만한 하이퍼 바디
        this.addHp(475L);               // 쓸만한 어드밴스드 블레스

        this.setAbility(new ReuseBossCritical());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new IronWill());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new DemonAvengerUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperDemonAvenger(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    public void Doping() {
        super.Doping();
        this.addHp(-30L);               // 향상된 10단계 물약
        this.addHp(2000L);              // 익스트림 골드
    }

    public Long getFinalHp() {
        return (long) Math.floor(
                (this.getAp() / 14 + this.getHp() / 17.5)
                        * (1 + this.getMainStatP() * 0.01)
                        + this.getPerXMainStat() / 17.5
        );
    }

    public Long getFinalHpHyperBodyX() {
        return (long) Math.floor(
                (this.getAp() / 14 + this.getHp() / 17.5)
                * (1 + (this.getMainStatP() - 40) * 0.01)
                + this.getPerXMainStat() / 17.5
        );
    }

    public Long getStr() {
        return (long) Math.floor(
                this.getMainStat()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXSubStat();
    }

    public Long getAp() {
        return this.getLevel() * 90 + 545;
    }

    public Long getStatDamage() {
        return (long) (Math.floor(
                this.getFinalHp()
                + this.getStr()) * 0.01
                * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                * this.getConstant()
                * (1 + this.getDamage() * 0.01)
                * this.getFinalDamage()
        );
    }

    @Override
    public Object[] getOpject() {
        Long attMagic;
        Long attMagicP;
        if (this.getAtt() > this.getMagic()) {
            attMagic = this.getAtt();
            attMagicP = this.getAttP();
        } else {
            attMagic = this.getMagic();
            attMagicP = this.getMagicP();
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery(), this.getLevel(),
                this.getFinalHp(), this.getFinalHpHyperBodyX(), this.getAp(),
                this.getStr(), "X", this.getStatDamage(), this.getDamage(),
                this.getBossDamage(), this.getIgnoreDefense(), this.getCriticalDamage(),
                this.getCriticalP(), "114", this.getWeaponAttMagic(), this.getPerXMainStat(),
                this.getPlusBuffDuration(), this.getReuse(), this.getCooldownReductionSec(),
                this.getFinalDamage()
        };
        return result;
    }
}
